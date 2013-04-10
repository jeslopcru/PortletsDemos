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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the task item service. This utility wraps {@link TaskItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jesus
 * @see TaskItemPersistence
 * @see TaskItemPersistenceImpl
 * @generated
 */
public class TaskItemUtil {
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
	public static void clearCache(TaskItem taskItem) {
		getPersistence().clearCache(taskItem);
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
	public static List<TaskItem> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TaskItem update(TaskItem taskItem, boolean merge)
		throws SystemException {
		return getPersistence().update(taskItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TaskItem update(TaskItem taskItem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taskItem, merge, serviceContext);
	}

	/**
	* Caches the task item in the entity cache if it is enabled.
	*
	* @param taskItem the task item
	*/
	public static void cacheResult(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem) {
		getPersistence().cacheResult(taskItem);
	}

	/**
	* Caches the task items in the entity cache if it is enabled.
	*
	* @param taskItems the task items
	*/
	public static void cacheResult(
		java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> taskItems) {
		getPersistence().cacheResult(taskItems);
	}

	/**
	* Creates a new task item with the primary key. Does not add the task item to the database.
	*
	* @param id the primary key for the new task item
	* @return the new task item
	*/
	public static com.jesuslc.demos.browntasks.model.TaskItem create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task item
	* @return the task item that was removed
	* @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskItem remove(long id)
		throws com.jesuslc.demos.browntasks.NoSuchTaskItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.jesuslc.demos.browntasks.model.TaskItem updateImpl(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taskItem, merge);
	}

	/**
	* Returns the task item with the primary key or throws a {@link com.jesuslc.demos.browntasks.NoSuchTaskItemException} if it could not be found.
	*
	* @param id the primary key of the task item
	* @return the task item
	* @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskItem findByPrimaryKey(
		long id)
		throws com.jesuslc.demos.browntasks.NoSuchTaskItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the task item
	* @return the task item, or <code>null</code> if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskItem fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the task items.
	*
	* @return the task items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the task items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of task items.
	*
	* @return the number of task items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaskItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaskItemPersistence)PortletBeanLocatorUtil.locate(com.jesuslc.demos.browntasks.service.ClpSerializer.getServletContextName(),
					TaskItemPersistence.class.getName());

			ReferenceRegistry.registerReference(TaskItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TaskItemPersistence persistence) {
	}

	private static TaskItemPersistence _persistence;
}