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

import com.jesuslc.demos.browntasks.service.TaskListLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jesus
 */
public class TaskListClp extends BaseModelImpl<TaskList> implements TaskList {
	public TaskListClp() {
	}

	public Class<?> getModelClass() {
		return TaskList.class;
	}

	public String getModelClassName() {
		return TaskList.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("portlet", getPortlet());
		attributes.put("description", getDescription());
		attributes.put("weight", getWeight());

		return attributes;
	}

	@Override
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getPortlet() {
		return _portlet;
	}

	public void setPortlet(String portlet) {
		_portlet = portlet;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public BaseModel<?> getTaskListRemoteModel() {
		return _taskListRemoteModel;
	}

	public void setTaskListRemoteModel(BaseModel<?> taskListRemoteModel) {
		_taskListRemoteModel = taskListRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaskListLocalServiceUtil.addTaskList(this);
		}
		else {
			TaskListLocalServiceUtil.updateTaskList(this);
		}
	}

	@Override
	public TaskList toEscapedModel() {
		return (TaskList)Proxy.newProxyInstance(TaskList.class.getClassLoader(),
			new Class[] { TaskList.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaskListClp clone = new TaskListClp();

		clone.setId(getId());
		clone.setPortlet(getPortlet());
		clone.setDescription(getDescription());
		clone.setWeight(getWeight());

		return clone;
	}

	public int compareTo(TaskList taskList) {
		long primaryKey = taskList.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TaskListClp taskList = null;

		try {
			taskList = (TaskListClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taskList.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", portlet=");
		sb.append(getPortlet());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.jesuslc.demos.browntasks.model.TaskList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portlet</column-name><column-value><![CDATA[");
		sb.append(getPortlet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _portlet;
	private String _description;
	private int _weight;
	private BaseModel<?> _taskListRemoteModel;
}