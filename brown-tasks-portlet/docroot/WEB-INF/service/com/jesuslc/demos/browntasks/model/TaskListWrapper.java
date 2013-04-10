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

package com.jesuslc.demos.browntasks.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TaskList}.
 * </p>
 *
 * @author    Jesus
 * @see       TaskList
 * @generated
 */
public class TaskListWrapper implements TaskList, ModelWrapper<TaskList> {
	public TaskListWrapper(TaskList taskList) {
		_taskList = taskList;
	}

	public Class<?> getModelClass() {
		return TaskList.class;
	}

	public String getModelClassName() {
		return TaskList.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("portlet", getPortlet());
		attributes.put("description", getDescription());
		attributes.put("weight", getWeight());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String portlet = (String)attributes.get("portlet");

		if (portlet != null) {
			setPortlet(portlet);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}
	}

	/**
	* Returns the primary key of this task list.
	*
	* @return the primary key of this task list
	*/
	public long getPrimaryKey() {
		return _taskList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this task list.
	*
	* @param primaryKey the primary key of this task list
	*/
	public void setPrimaryKey(long primaryKey) {
		_taskList.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this task list.
	*
	* @return the ID of this task list
	*/
	public long getId() {
		return _taskList.getId();
	}

	/**
	* Sets the ID of this task list.
	*
	* @param id the ID of this task list
	*/
	public void setId(long id) {
		_taskList.setId(id);
	}

	/**
	* Returns the portlet of this task list.
	*
	* @return the portlet of this task list
	*/
	public java.lang.String getPortlet() {
		return _taskList.getPortlet();
	}

	/**
	* Sets the portlet of this task list.
	*
	* @param portlet the portlet of this task list
	*/
	public void setPortlet(java.lang.String portlet) {
		_taskList.setPortlet(portlet);
	}

	/**
	* Returns the description of this task list.
	*
	* @return the description of this task list
	*/
	public java.lang.String getDescription() {
		return _taskList.getDescription();
	}

	/**
	* Sets the description of this task list.
	*
	* @param description the description of this task list
	*/
	public void setDescription(java.lang.String description) {
		_taskList.setDescription(description);
	}

	/**
	* Returns the weight of this task list.
	*
	* @return the weight of this task list
	*/
	public int getWeight() {
		return _taskList.getWeight();
	}

	/**
	* Sets the weight of this task list.
	*
	* @param weight the weight of this task list
	*/
	public void setWeight(int weight) {
		_taskList.setWeight(weight);
	}

	public boolean isNew() {
		return _taskList.isNew();
	}

	public void setNew(boolean n) {
		_taskList.setNew(n);
	}

	public boolean isCachedModel() {
		return _taskList.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_taskList.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _taskList.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _taskList.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taskList.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taskList.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taskList.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaskListWrapper((TaskList)_taskList.clone());
	}

	public int compareTo(com.jesuslc.demos.browntasks.model.TaskList taskList) {
		return _taskList.compareTo(taskList);
	}

	@Override
	public int hashCode() {
		return _taskList.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.jesuslc.demos.browntasks.model.TaskList> toCacheModel() {
		return _taskList.toCacheModel();
	}

	public com.jesuslc.demos.browntasks.model.TaskList toEscapedModel() {
		return new TaskListWrapper(_taskList.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taskList.toString();
	}

	public java.lang.String toXmlString() {
		return _taskList.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taskList.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TaskList getWrappedTaskList() {
		return _taskList;
	}

	public TaskList getWrappedModel() {
		return _taskList;
	}

	public void resetOriginalValues() {
		_taskList.resetOriginalValues();
	}

	private TaskList _taskList;
}