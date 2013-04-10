/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jesuslc.demos.browntasks.service.persistence;

import com.jesuslc.demos.browntasks.model.TaskItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the task item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jesus
 * @see TaskItemPersistenceImpl
 * @see TaskItemUtil
 * @generated
 */
public interface TaskItemPersistence extends BasePersistence<TaskItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskItemUtil} to access the task item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the task item in the entity cache if it is enabled.
	*
	* @param taskItem the task item
	*/
	public void cacheResult(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem);

	/**
	* Caches the task items in the entity cache if it is enabled.
	*
	* @param taskItems the task items
	*/
	public void cacheResult(
		java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> taskItems);

	/**
	* Creates a new task item with the primary key. Does not add the task item to the database.
	*
	* @param id the primary key for the new task item
	* @return the new task item
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem create(long id);

	/**
	* Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task item
	* @return the task item that was removed
	* @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem remove(long id)
		throws com.jesuslc.demos.browntasks.NoSuchTaskItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jesuslc.demos.browntasks.model.TaskItem updateImpl(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the task item with the primary key or throws a {@link com.jesuslc.demos.browntasks.NoSuchTaskItemException} if it could not be found.
	*
	* @param id the primary key of the task item
	* @return the task item
	* @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem findByPrimaryKey(long id)
		throws com.jesuslc.demos.browntasks.NoSuchTaskItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the task item
	* @return the task item, or <code>null</code> if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the task items.
	*
	* @return the task items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the task items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of task items
	* @param end the upper bound of the range of task items (not inclusive)
	* @return the range of task items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the task items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of task items
	* @param end the upper bound of the range of task items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the task items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of task items.
	*
	* @return the number of task items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}