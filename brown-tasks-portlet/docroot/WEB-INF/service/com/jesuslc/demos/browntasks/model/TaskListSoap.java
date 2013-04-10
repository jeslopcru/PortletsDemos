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
public class TaskListSoap implements Serializable {
	public static TaskListSoap toSoapModel(TaskList model) {
		TaskListSoap soapModel = new TaskListSoap();

		soapModel.setId(model.getId());
		soapModel.setPortlet(model.getPortlet());
		soapModel.setDescription(model.getDescription());
		soapModel.setWeight(model.getWeight());

		return soapModel;
	}

	public static TaskListSoap[] toSoapModels(TaskList[] models) {
		TaskListSoap[] soapModels = new TaskListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaskListSoap[][] toSoapModels(TaskList[][] models) {
		TaskListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaskListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaskListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaskListSoap[] toSoapModels(List<TaskList> models) {
		List<TaskListSoap> soapModels = new ArrayList<TaskListSoap>(models.size());

		for (TaskList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaskListSoap[soapModels.size()]);
	}

	public TaskListSoap() {
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

	private long _id;
	private String _portlet;
	private String _description;
	private int _weight;
}