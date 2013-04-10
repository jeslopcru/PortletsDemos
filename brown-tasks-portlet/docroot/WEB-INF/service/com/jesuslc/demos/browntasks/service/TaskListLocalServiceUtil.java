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

package com.jesuslc.demos.browntasks.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the task list local service. This utility wraps {@link com.jesuslc.demos.browntasks.service.impl.TaskListLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jesus
 * @see TaskListLocalService
 * @see com.jesuslc.demos.browntasks.service.base.TaskListLocalServiceBaseImpl
 * @see com.jesuslc.demos.browntasks.service.impl.TaskListLocalServiceImpl
 * @generated
 */
public class TaskListLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.jesuslc.demos.browntasks.service.impl.TaskListLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the task list to the database. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @return the task list that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList addTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTaskList(taskList);
	}

	/**
	* Creates a new task list with the primary key. Does not add the task list to the database.
	*
	* @param id the primary key for the new task list
	* @return the new task list
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList createTaskList(
		long id) {
		return getService().createTaskList(id);
	}

	/**
	* Deletes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task list
	* @return the task list that was removed
	* @throws PortalException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList deleteTaskList(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTaskList(id);
	}

	/**
	* Deletes the task list from the database. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @return the task list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList deleteTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTaskList(taskList);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.jesuslc.demos.browntasks.model.TaskList fetchTaskList(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTaskList(id);
	}

	/**
	* Returns the task list with the primary key.
	*
	* @param id the primary key of the task list
	* @return the task list
	* @throws PortalException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList getTaskList(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaskList(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.jesuslc.demos.browntasks.model.TaskList> getTaskLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaskLists(start, end);
	}

	/**
	* Returns the number of task lists.
	*
	* @return the number of task lists
	* @throws SystemException if a system exception occurred
	*/
	public static int getTaskListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTaskListsCount();
	}

	/**
	* Updates the task list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @return the task list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList updateTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaskList(taskList);
	}

	/**
	* Updates the task list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @param merge whether to merge the task list with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the task list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jesuslc.demos.browntasks.model.TaskList updateTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTaskList(taskList, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static TaskListLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TaskListLocalService.class.getName());

			if (invokableLocalService instanceof TaskListLocalService) {
				_service = (TaskListLocalService)invokableLocalService;
			}
			else {
				_service = new TaskListLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TaskListLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TaskListLocalService service) {
	}

	private static TaskListLocalService _service;
}