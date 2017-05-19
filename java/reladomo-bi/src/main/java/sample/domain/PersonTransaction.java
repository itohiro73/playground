package sample.domain;
import java.sql.Timestamp;
/********************************************************************************
* File        : $Source:  $
* Version     : $Revision:  $
* Date        : $Date:  $
* Modified by : $Author:  $
*******************************************************************************
*/
public class PersonTransaction extends PersonTransactionAbstract
{
	public PersonTransaction(Timestamp processingDate
	)
	{
		super(processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public PersonTransaction()
	{
		this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
	}
}
