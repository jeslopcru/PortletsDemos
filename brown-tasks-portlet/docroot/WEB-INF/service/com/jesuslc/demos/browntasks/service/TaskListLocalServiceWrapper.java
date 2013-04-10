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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TaskListLocalService}.
 * </p>
 *
 * @author    Jesus
 * @see       TaskListLocalService
 * @generated
 */
public class TaskListLocalServiceWrapper implements TaskListLocalService,
	ServiceWrapper<TaskListLocalService> {
	public TaskListLocalServiceWrapper(
		TaskListLocalService taskListLocalService) {
		_taskListLocalService = taskListLocalService;
	}

	/**
	* Adds the task list to the database. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @return the task list that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskList addTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.addTaskList(taskList);
	}

	/**
	* Creates a new task list with the primary key. Does not add the task list to the database.
	*
	* @param id the primary key for the new task list
	* @return the new task list
	*/
	public com.jesuslc.demos.browntasks.model.TaskList createTaskList(long id) {
		return _taskListLocalService.createTaskList(id);
	}

	/**
	* Deletes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task list
	* @return the task list that was removed
	* @throws PortalException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskList deleteTaskList(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.deleteTaskList(id);
	}

	/**
	* Deletes the task list from the database. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @return the task list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskList deleteTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.deleteTaskList(taskList);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskListLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jesuslc.demos.browntasks.model.TaskList fetchTaskList(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.fetchTaskList(id);
	}

	/**
	* Returns the task list with the primary key.
	*
	* @param id the primary key of the task list
	* @return the task list
	* @throws PortalException if a task list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskList getTaskList(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.getTaskList(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.jesuslc.demos.browntasks.model.TaskList> getTaskLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.getTaskLists(start, end);
	}

	/**
	* Returns the number of task lists.
	*
	* @return the number of task lists
	* @throws SystemException if a system exception occurred
	*/
	public int getTaskListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.getTaskListsCount();
	}

	/**
	* Updates the task list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @return the task list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskList updateTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.updateTaskList(taskList);
	}

	/**
	* Updates the task list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskList the task list
	* @param merge whether to merge the task list with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the task list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskList updateTaskList(
		com.jesuslc.demos.browntasks.model.TaskList taskList, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskListLocalService.updateTaskList(taskList, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _taskListLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taskListLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taskListLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TaskListLocalService getWrappedTaskListLocalService() {
		return _taskListLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTaskListLocalService(
		TaskListLocalService taskListLocalService) {
		_taskListLocalService = taskListLocalService;
	}

	public TaskListLocalService getWrappedService() {
		return _taskListLocalService;
	}

	public void setWrappedService(TaskListLocalService taskListLocalService) {
		_taskListLocalService = taskListLocalService;
	}

	private TaskListLocalService _taskListLocalService;
}