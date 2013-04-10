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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Jesus
 * @generated
 */
public class TaskItemSoap implements Serializable {
	public static TaskItemSoap toSoapModel(TaskItem model) {
		TaskItemSoap soapModel = new TaskItemSoap();

		soapModel.setId(model.getId());
		soapModel.setList(model.getList());
		soapModel.setLabel(model.getLabel());
		soapModel.setWeight(model.getWeight());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TaskItemSoap[] toSoapModels(TaskItem[] models) {
		TaskItemSoap[] soapModels = new TaskItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskItemSoap[][] toSoapModels(TaskItem[][] models) {
		TaskItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskItemSoap[] toSoapModels(List<TaskItem> models) {
		List<TaskItemSoap> soapModels = new ArrayList<TaskItemSoap>(models.size());

		for (TaskItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskItemSoap[soapModels.size()]);
	}

	public TaskItemSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private long _list;
	private String _label;
	private int _weight;
	private String _description;
	private int _status;
}