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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing TaskList in entity cache.
 *
 * @author Jesus
 * @see TaskList
 * @generated
 */
public class TaskListCacheModel implements CacheModel<TaskList>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", portlet=");
		sb.append(portlet);
		sb.append(", description=");
		sb.append(description);
		sb.append(", weight=");
		sb.append(weight);
		sb.append("}");

		return sb.toString();
	}

	public TaskList toEntityModel() {
		TaskListImpl taskListImpl = new TaskListImpl();

		taskListImpl.setId(id);

		if (portlet == null) {
			taskListImpl.setPortlet(StringPool.BLANK);
		}
		else {
			taskListImpl.setPortlet(portlet);
		}

		if (description == null) {
			taskListImpl.setDescription(StringPool.BLANK);
		}
		else {
			taskListImpl.setDescription(description);
		}

		taskListImpl.setWeight(weight);

		taskListImpl.resetOriginalValues();

		return taskListImpl;
	}

	public long id;
	public String portlet;
	public String description;
	public int weight;
}