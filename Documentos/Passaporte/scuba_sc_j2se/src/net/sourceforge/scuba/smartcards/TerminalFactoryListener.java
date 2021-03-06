/* 
 * This file is part of the SCUBA smart card framework.
 * 
 * SCUBA is free software: you can redistribute it and/or modify it under the 
 * terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * SCUBA is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * SCUBA. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2011-2012 The SCUBA team.
 * 
 * $Id: TerminalFactoryListener.java 183 2012-09-04 18:54:58Z pimvullers $
 */

package net.sourceforge.scuba.smartcards;

import java.util.EventListener;

/**
 * Interface for terminal addition and removal event observers.
 *
 * @author Pim Vullers (pim@cs.ru.nl)
 *
 * @version $Revision: 183 $
 */
public interface TerminalFactoryListener extends EventListener
{
	/**
	 * Called when terminal added.
	 *
	 * @param cte addition event
	 */
	void cardTerminalAdded(CardTerminalEvent cte);

	/**
	 * Called when terminal removed.
	 *
	 * @param cte removal event
	 */
	void cardTerminalRemoved(CardTerminalEvent cte);
}
