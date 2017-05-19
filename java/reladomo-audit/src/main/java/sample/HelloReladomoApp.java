/*
 Copyright 2016 Goldman Sachs.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package sample;

import com.gs.fw.common.mithra.MithraManager;
import com.gs.fw.common.mithra.MithraManagerProvider;
import com.gs.fw.common.mithra.MithraTransaction;
import com.gs.fw.common.mithra.finder.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.domain.*;
import sample.util.H2ConnectionManager;

import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HelloReladomoApp
{
    private static Logger logger = LoggerFactory.getLogger(HelloReladomoApp.class.getName());
    private static final int MAX_TRANSACTION_TIMEOUT = 120;

    public static void main(String[] args)
    {
        HelloReladomoApp app = new HelloReladomoApp();
        initialize(app);

        Employee hanako = MithraManagerProvider.getMithraManager().executeTransactionalCommand(tx -> {
            //3月1日をシミュレートするためのコード。本番環境ではダメ、絶対！
            Timestamp procdate = Timestamp.valueOf(LocalDateTime.of(2017, 3, 1, 0, 0));
            simulateProcessingDateAs(procdate, tx);

            //3月1日にこのコードが実行される
            Employee hanako1 = new Employee(); //メモリ上にオブジェクト作成
            hanako1.setLastName("鈴木");
            hanako1.setFirstName("花子");
            hanako1.insert(); // データベースに挿入
            return hanako1; //トランザクション終了後に使用したいオブジェクトを返り値として与えることができる。ここでは必要ないのでnullを返す。
        });
//
//        Operation op = EmployeeFinder.lastName().eq("鈴木")
//                .and(EmployeeFinder.firstName().eq("花子"));
//        final Employee hanako2 = EmployeeFinder.findOne(op); //遅延ロードされるのでこの時点ではフェッチされない

        MithraManagerProvider.getMithraManager().executeTransactionalCommand(tx -> {
            Timestamp procdate = Timestamp.valueOf(LocalDateTime.of(2017, 6, 6, 0, 0));
            simulateProcessingDateAs(procdate, tx);

            //6月6日にこのコードが実行される
            hanako.setLastName("斉藤"); // この時点で遅延フェッチ＆アップデート
            return null; //トランザクション終了後に使用したいオブジェクトを返り値として与えることができる。ここでは必要ないのでnullを返す。
        });


        MithraManagerProvider.getMithraManager().executeTransactionalCommand(tx -> {
            Timestamp procdate = Timestamp.valueOf(LocalDateTime.of(2017, 6, 8, 0, 0));
            simulateProcessingDateAs(procdate, tx);

            //6月8日にこのコードが実行される
            hanako.setLastName("斎藤"); // この時点で遅延フェッチ＆アップデート
            return null; //トランザクション終了後に使用したいオブジェクトを返り値として与えることができる。ここでは必要ないのでnullを返す。
        });

        MithraManagerProvider.getMithraManager().executeTransactionalCommand(tx -> {
            Timestamp procdate = Timestamp.valueOf(LocalDateTime.of(2017, 12, 1, 0, 0));
            simulateProcessingDateAs(procdate, tx);

            //12月1日にこのコードが実行される
            hanako.terminate(); // OUT = NOW
            return null; //トランザクション終了後に使用したいオブジェクトを返り値として与えることができる。ここでは必要ないのでnullを返す。
        });

        Timestamp mar5 = Timestamp.valueOf(LocalDateTime.of(2017, 3, 5, 0, 0));
        Employee hanakoMar5 = EmployeeFinder.findOne(EmployeeFinder.processingDate().eq(mar5));
        logger.info("Mar 5: " + hanakoMar5.getLastName() + " " + hanakoMar5.getFirstName());


        Timestamp jun5 = Timestamp.valueOf(LocalDateTime.of(2017, 6, 5, 0, 0));
        Employee hanakoJun5 = EmployeeFinder.findOne(EmployeeFinder.processingDate().eq(jun5));
        logger.info("June 5: " + hanakoJun5.getLastName() + " " + hanakoJun5.getFirstName());
        Timestamp jun6 = Timestamp.valueOf(LocalDateTime.of(2017, 6, 6, 0, 0));
        Employee hanakoJun6 = EmployeeFinder.findOne(EmployeeFinder.processingDate().eq(jun6));
        logger.info("June 6: " + hanakoJun6.getLastName() + " " + hanakoJun6.getFirstName());
        Timestamp jun7 = Timestamp.valueOf(LocalDateTime.of(2017, 6, 7, 0, 0));
        Employee hanakoJun7 = EmployeeFinder.findOne(EmployeeFinder.processingDate().eq(jun7));
        logger.info("June 7: " + hanakoJun7.getLastName() + " " + hanakoJun7.getFirstName());
        Timestamp jun8 = Timestamp.valueOf(LocalDateTime.of(2017, 6, 8, 0, 0));
        Employee hanakoJun8 = EmployeeFinder.findOne(EmployeeFinder.processingDate().eq(jun8));
        logger.info("June 8: " + hanakoJun8.getLastName() + " " + hanakoJun8.getFirstName());

        Timestamp nov30 = Timestamp.valueOf(LocalDateTime.of(2017, 11, 30, 0, 0));
        Employee hanakoNov30 = EmployeeFinder.findOne(EmployeeFinder.processingDate().eq(nov30));
        logger.info("Nov 30: " + hanakoNov30.getLastName() + " " + hanakoNov30.getFirstName());
    }

    private static void simulateProcessingDateAs(Timestamp procdate, MithraTransaction tx) {
        tx.setProcessingStartTime(procdate.getTime());
    }

    private static void initialize(HelloReladomoApp app)
    {
        try
        {
            // This line is added to make in-memory tables ready.
            // It's not typically done in production app that usually connects to physical db
            H2ConnectionManager.getInstance().prepareTables();

            app.initialiseReladomo();
            app.loadReladomoConfigurationXml("reladomo/config/ReladomoRuntimeConfig.xml");
        }
        catch(Exception e)
        {
            logger.error("Couldn't run HelloReladomoApp.", e);
        }
    }

    private void initialiseReladomo() throws Exception
    {
        try
        {
            logger.info("Transaction Timeout is " + MAX_TRANSACTION_TIMEOUT);
            MithraManager mithraManager = MithraManagerProvider.getMithraManager();
            mithraManager.setTransactionTimeout(MAX_TRANSACTION_TIMEOUT);
            // Notification should be configured here. Refer to notification/Notification.html under reladomo-javadoc.jar.
        }
        catch (Exception e)
        {
            logger.error("Unable to initialise Reladomo!", e);
            throw new Exception("Unable to initialise Reladomo!", e);
        }
        logger.info("Reladomo has been initialised!");
    }

    private void loadReladomoConfigurationXml(String reladomoRuntimeConfig) throws Exception
    {
        logger.info("Reladomo configuration XML is " + reladomoRuntimeConfig);
        InputStream is = HelloReladomoApp.class.getClassLoader().getResourceAsStream(reladomoRuntimeConfig);
        if (is == null) throw new Exception("can't find file: " + reladomoRuntimeConfig + " in classpath");
        MithraManagerProvider.getMithraManager().readConfiguration(is);
        try
        {
            is.close();
        }
        catch (java.io.IOException e)
        {
            logger.error("Unable to initialise Reladomo!", e);
            throw new Exception("Unable to initialise Reladomo!", e);
        }
        logger.info("Reladomo configuration XML " + reladomoRuntimeConfig+" is now loaded.");
    }
}
