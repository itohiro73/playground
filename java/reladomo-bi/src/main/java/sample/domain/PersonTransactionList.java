package sample.domain;
import com.gs.fw.finder.Operation;
import java.util.*;
/********************************************************************************
* File        : $Source:  $
* Version     : $Revision:  $
* Date        : $Date:  $
* Modified by : $Author:  $
*******************************************************************************
*/
public class PersonTransactionList extends PersonTransactionListAbstract
{
	public PersonTransactionList()
	{
		super();
	}

	public PersonTransactionList(int initialSize)
	{
		super(initialSize);
	}

	public PersonTransactionList(Collection c)
	{
		super(c);
	}

	public PersonTransactionList(Operation operation)
	{
		super(operation);
	}
}
