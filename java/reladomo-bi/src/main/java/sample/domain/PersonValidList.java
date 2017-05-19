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
public class PersonValidList extends PersonValidListAbstract
{
	public PersonValidList()
	{
		super();
	}

	public PersonValidList(int initialSize)
	{
		super(initialSize);
	}

	public PersonValidList(Collection c)
	{
		super(c);
	}

	public PersonValidList(Operation operation)
	{
		super(operation);
	}
}
