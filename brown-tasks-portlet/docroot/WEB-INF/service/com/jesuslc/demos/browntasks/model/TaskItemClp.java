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

import com.jesuslc.demos.browntasks.service.TaskItemLocalServiceUtil;

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
public class TaskItemClp extends BaseModelImpl<TaskItem> implements TaskItem {
	public TaskItemClp() {
	}

	public Class<?> getModelClass() {
		return TaskItem.class;
	}

	public String getModelClassName() {
		return TaskItem.class.getName();
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
		attributes.put("list", getList());
		attributes.put("label", getLabel());
		attributes.put("weight", getWeight());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long list = (Long)attributes.get("list");

		if (list != null) {
			setList(list);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getList() {
		return _list;
	}

	public void setList(long list) {
		_list = list;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public BaseModel<?> getTaskItemRemoteModel() {
		return _taskItemRemoteModel;
	}

	public void setTaskItemRemoteModel(BaseModel<?> taskItemRemoteModel) {
		_taskItemRemoteModel = taskItemRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TaskItemLocalServiceUtil.addTaskItem(this);
		}
		else {
			TaskItemLocalServiceUtil.updateTaskItem(this);
		}
	}

	@Override
	public TaskItem toEscapedModel() {
		return (TaskItem)Proxy.newProxyInstance(TaskItem.class.getClassLoader(),
			new Class[] { TaskItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaskItemClp clone = new TaskItemClp();

		clone.setId(getId());
		clone.setList(getList());
		clone.setLabel(getLabel());
		clone.setWeight(getWeight());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(TaskItem taskItem) {
		long primaryKey = taskItem.getPrimaryKey();

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

		TaskItemClp taskItem = null;

		try {
			taskItem = (TaskItemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = taskItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", list=");
		sb.append(getList());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", weight=");
		sb.append(getWeight());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.jesuslc.demos.browntasks.model.TaskItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>list</column-name><column-value><![CDATA[");
		sb.append(getList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight</column-name><column-value><![CDATA[");
		sb.append(getWeight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _list;
	private String _label;
	private int _weight;
	private String _description;
	private int _status;
	private BaseModel<?> _taskItemRemoteModel;
}