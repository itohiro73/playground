package sample.domain;
import java.sql.Timestamp;
/********************************************************************************
* File        : $Source:  $
* Version     : $Revision:  $
* Date        : $Date:  $
* Modified by : $Author:  $
*******************************************************************************
*/
public class Employee extends EmployeeAbstract
{
	public Employee(Timestamp processingDate
	)
	{
		super(processingDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}

	public Employee()
	{
		this(com.gs.fw.common.mithra.util.DefaultInfinityTimestamp.getDefaultInfinity());
	}
}
