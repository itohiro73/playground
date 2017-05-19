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
public class EmployeeList extends EmployeeListAbstract
{
	public EmployeeList()
	{
		super();
	}

	public EmployeeList(int initialSize)
	{
		super(initialSize);
	}

	public EmployeeList(Collection c)
	{
		super(c);
	}

	public EmployeeList(Operation operation)
	{
		super(operation);
	}
}
