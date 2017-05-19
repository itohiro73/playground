package sample.domain;
import java.sql.Timestamp;
/********************************************************************************
* File        : $Source:  $
* Version     : $Revision:  $
* Date        : $Date:  $
* Modified by : $Author:  $
*******************************************************************************
*/
public class PersonValid extends PersonValidAbstract
{
	public PersonValid(Timestamp businessDate
	)
	{
		super(businessDate
		);
		// You must not modify this constructor. Mithra calls this internally.
		// You can call this constructor. You can also add new constructors.
	}
}
