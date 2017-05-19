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
public class PersonBiTemporalList extends PersonBiTemporalListAbstract
{
	public PersonBiTemporalList()
	{
		super();
	}

	public PersonBiTemporalList(int initialSize)
	{
		super(initialSize);
	}

	public PersonBiTemporalList(Collection c)
	{
		super(c);
	}

	public PersonBiTemporalList(Operation operation)
	{
		super(operation);
	}
}
