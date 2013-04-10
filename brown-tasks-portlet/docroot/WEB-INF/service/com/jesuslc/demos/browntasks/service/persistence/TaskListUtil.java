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

import com.jesuslc.demos.browntasks.model.TaskList;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the task list service. This utility wraps {@link TaskListPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jesus
 * @see TaskListPersistence
 * @see TaskListPersistenceImpl
 * @generated
 */
public class TaskListUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TaskList taskList) {
		getPersistence().clearCache(taskList);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaskList> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TaskList update(TaskList taskList, boolean merge)
		throws SystemException {
		return getPersistence().update(taskList, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TaskList update(TaskList taskList, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taskList, merge, serviceContext);
	}

	/**
	* Caches the task list in the entity cache if it is enabled.
	*
	* @param taskList the task list
	*/
	public static void cacheResult(
		com.jesuslc.demos.browntasks.model.TaskList taskList) {
		getPersistence().cacheResult(taskList);
	}

	/**
	* Caches the task lists in the entity cache if it is enabled.
	*
	* @param taskLists the task lists
	*/
	public static void cacheResult(
		java.util.List<com.jesuslc.demos.browntasks.model.TaskList> taskLists) {
		getPersistence().cacheResult(taskLists);
	}

	/**
	* Creates a new task list with the primary key. Does not add the task list to the database.
	*
	* @param id the primary key for the new task list
	* @return the new task list
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task list
	* @return the task list that was removed
	* @throws com.jesuslc.demos.browntasks.NoSuchTaskListException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList remove(long id)
		throws com.jesuslc.demos.browntasks.NoSuchTaskListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.jesuslc.demos.browntasks.model.TaskList updateImpl(
		com.jesuslc.demos.browntasks.model.TaskList taskList, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taskList, merge);
	}

	/**
	* Returns the task list with the primary key or throws a {@link com.jesuslc.demos.browntasks.NoSuchTaskListException} if it could not be found.
	*
	* @param id the primary key of the task list
	* @return the task list
	* @throws com.jesuslc.demos.browntasks.NoSuchTaskListException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList findByPrimaryKey(
		long id)
		throws com.jesuslc.demos.browntasks.NoSuchTaskListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the task list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the task list
	* @return the task list, or <code>null</code> if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the task lists.
	*
	* @return the task lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the task lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of task lists
	* @param end the upper bound of the range of task lists (not inclusive)
	* @return the range of task lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the task lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of task lists
	* @param end the upper bound of the range of task lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the task lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of task lists.
	*
	* @return the number of task lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaskListPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaskListPersistence)PortletBeanLocatorUtil.locate(com.jesuslc.demos.browntasks.service.ClpSerializer.getServletContextName(),
					TaskListPersistence.class.getName());

			ReferenceRegistry.registerReference(TaskListUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TaskListPersistence persistence) {
	}

	private static TaskListPersistence _persistence;
}