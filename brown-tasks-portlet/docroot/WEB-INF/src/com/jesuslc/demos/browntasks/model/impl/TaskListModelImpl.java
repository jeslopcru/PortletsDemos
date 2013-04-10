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

package com.jesuslc.demos.browntasks.model.impl;

import com.jesuslc.demos.browntasks.model.TaskList;
import com.jesuslc.demos.browntasks.model.TaskListModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TaskList service. Represents a row in the &quot;sb_TaskList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.jesuslc.demos.browntasks.model.TaskListModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskListImpl}.
 * </p>
 *
 * @author Jesus
 * @see TaskListImpl
 * @see com.jesuslc.demos.browntasks.model.TaskList
 * @see com.jesuslc.demos.browntasks.model.TaskListModel
 * @generated
 */
public class TaskListModelImpl extends BaseModelImpl<TaskList>
	implements TaskListModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task list model instance should use the {@link com.jesuslc.demos.browntasks.model.TaskList} interface instead.
	 */
	public static final String TABLE_NAME = "sb_TaskList";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "portlet", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "weight", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table sb_TaskList (id_ LONG not null primary key,portlet VARCHAR(75) null,description VARCHAR(75) null,weight INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table sb_TaskList";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.jesuslc.demos.browntasks.model.TaskList"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.jesuslc.demos.browntasks.model.TaskList"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.jesuslc.demos.browntasks.model.TaskList"));

	public TaskListModelImpl() {
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

	public Class<?> getModelClass() {
		return TaskList.class;
	}

	public String getModelClassName() {
		return TaskList.class.getName();
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
		if (_portlet == null) {
			return StringPool.BLANK;
		}
		else {
			return _portlet;
		}
	}

	public void setPortlet(String portlet) {
		_portlet = portlet;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TaskList.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TaskList toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (TaskList)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		TaskListImpl taskListImpl = new TaskListImpl();

		taskListImpl.setId(getId());
		taskListImpl.setPortlet(getPortlet());
		taskListImpl.setDescription(getDescription());
		taskListImpl.setWeight(getWeight());

		taskListImpl.resetOriginalValues();

		return taskListImpl;
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

		TaskList taskList = null;

		try {
			taskList = (TaskList)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<TaskList> toCacheModel() {
		TaskListCacheModel taskListCacheModel = new TaskListCacheModel();

		taskListCacheModel.id = getId();

		taskListCacheModel.portlet = getPortlet();

		String portlet = taskListCacheModel.portlet;

		if ((portlet != null) && (portlet.length() == 0)) {
			taskListCacheModel.portlet = null;
		}

		taskListCacheModel.description = getDescription();

		String description = taskListCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			taskListCacheModel.description = null;
		}

		taskListCacheModel.weight = getWeight();

		return taskListCacheModel;
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

	private static ClassLoader _classLoader = TaskList.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			TaskList.class
		};
	private long _id;
	private String _portlet;
	private String _description;
	private int _weight;
	private TaskList _escapedModelProxy;
}