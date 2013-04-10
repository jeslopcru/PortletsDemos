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
 * This class is a wrapper for {@link TaskItemLocalService}.
 * </p>
 *
 * @author    Jesus
 * @see       TaskItemLocalService
 * @generated
 */
public class TaskItemLocalServiceWrapper implements TaskItemLocalService,
	ServiceWrapper<TaskItemLocalService> {
	public TaskItemLocalServiceWrapper(
		TaskItemLocalService taskItemLocalService) {
		_taskItemLocalService = taskItemLocalService;
	}

	/**
	* Adds the task item to the database. Also notifies the appropriate model listeners.
	*
	* @param taskItem the task item
	* @return the task item that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem addTaskItem(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.addTaskItem(taskItem);
	}

	/**
	* Creates a new task item with the primary key. Does not add the task item to the database.
	*
	* @param id the primary key for the new task item
	* @return the new task item
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem createTaskItem(long id) {
		return _taskItemLocalService.createTaskItem(id);
	}

	/**
	* Deletes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the task item
	* @return the task item that was removed
	* @throws PortalException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem deleteTaskItem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.deleteTaskItem(id);
	}

	/**
	* Deletes the task item from the database. Also notifies the appropriate model listeners.
	*
	* @param taskItem the task item
	* @return the task item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem deleteTaskItem(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.deleteTaskItem(taskItem);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskItemLocalService.dynamicQuery();
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
		return _taskItemLocalService.dynamicQuery(dynamicQuery);
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
		return _taskItemLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _taskItemLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _taskItemLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.jesuslc.demos.browntasks.model.TaskItem fetchTaskItem(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.fetchTaskItem(id);
	}

	/**
	* Returns the task item with the primary key.
	*
	* @param id the primary key of the task item
	* @return the task item
	* @throws PortalException if a task item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem getTaskItem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.getTaskItem(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.jesuslc.demos.browntasks.model.TaskItem> getTaskItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.getTaskItems(start, end);
	}

	/**
	* Returns the number of task items.
	*
	* @return the number of task items
	* @throws SystemException if a system exception occurred
	*/
	public int getTaskItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.getTaskItemsCount();
	}

	/**
	* Updates the task item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskItem the task item
	* @return the task item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem updateTaskItem(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.updateTaskItem(taskItem);
	}

	/**
	* Updates the task item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taskItem the task item
	* @param merge whether to merge the task item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the task item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jesuslc.demos.browntasks.model.TaskItem updateTaskItem(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taskItemLocalService.updateTaskItem(taskItem, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _taskItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taskItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taskItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TaskItemLocalService getWrappedTaskItemLocalService() {
		return _taskItemLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTaskItemLocalService(
		TaskItemLocalService taskItemLocalService) {
		_taskItemLocalService = taskItemLocalService;
	}

	public TaskItemLocalService getWrappedService() {
		return _taskItemLocalService;
	}

	public void setWrappedService(TaskItemLocalService taskItemLocalService) {
		_taskItemLocalService = taskItemLocalService;
	}

	private TaskItemLocalService _taskItemLocalService;
}