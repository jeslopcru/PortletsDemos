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

import com.jesuslc.demos.browntasks.model.TaskItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing TaskItem in entity cache.
 *
 * @author Jesus
 * @see TaskItem
 * @generated
 */
public class TaskItemCacheModel implements CacheModel<TaskItem>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", list=");
		sb.append(list);
		sb.append(", label=");
		sb.append(label);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public TaskItem toEntityModel() {
		TaskItemImpl taskItemImpl = new TaskItemImpl();

		taskItemImpl.setId(id);
		taskItemImpl.setList(list);

		if (label == null) {
			taskItemImpl.setLabel(StringPool.BLANK);
		}
		else {
			taskItemImpl.setLabel(label);
		}

		taskItemImpl.setWeight(weight);

		if (description == null) {
			taskItemImpl.setDescription(StringPool.BLANK);
		}
		else {
			taskItemImpl.setDescription(description);
		}

		taskItemImpl.setStatus(status);

		taskItemImpl.resetOriginalValues();

		return taskItemImpl;
	}

	public long id;
	public long list;
	public String label;
	public int weight;
	public String description;
	public int status;
}