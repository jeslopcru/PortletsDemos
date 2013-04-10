package com.jesuslc.demos.browntasks.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.jesuslc.demos.browntasks.model.TaskItem;
import com.jesuslc.demos.browntasks.model.TaskList;
import com.jesuslc.demos.browntasks.service.TaskItemLocalServiceUtil;
import com.jesuslc.demos.browntasks.service.TaskListLocalServiceUtil;
import com.jesuslc.demos.browntasks.util.ModelAndView;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

public class DefaultController {

	public void handleActionRequest(ActionRequest request,
			ActionResponse response) throws IOException, PortletException {
	}

	public ModelAndView handleRenderRequest(RenderRequest request,
			RenderResponse response) throws IOException, PortletException {

		// objeto que representa al modelo y vista de 
		Map<String, Object> model = new HashMap<String, Object>();

		try {

			if (request.getParameter("order") != null) {
				model.put("order", request.getParameter("order"));
			}

			// view item
			String itemid = request.getParameter("itemid");

			if (itemid != null) {
				TaskItem l = TaskItemLocalServiceUtil.getTaskItem(Integer
						.parseInt(itemid));
				TaskList lObj = TaskListLocalServiceUtil.getTaskList(l
						.getList());

				model.put("listObj", lObj);
				model.put("item", l);
				model.put("list", "" + l.getList());
				model.put("statuses", new String[] { "Normal", "Waiting for",
						"Cancelled", "Finished" });

				return new ModelAndView("viewitem", model);
			}

			// read params
			String tab = request.getParameter("tabs1");
			String listid = request.getParameter("list");
			String order = request.getParameter("order");

			if (tab == null)
				tab = "";
			if (order == null)
				order = "weight";
			if (order.equals(""))
				order = "weight";

			model.put("formTab", tab);

			/* Load Lists */
			DynamicQuery dq = DynamicQueryFactoryUtil.forClass(TaskList.class);
			dq.addOrder(PropertyFactoryUtil.forName("weight").asc());

			List<TaskList> ls = TaskListLocalServiceUtil.dynamicQuery(dq);
			String names = "";

			for (int i = 0; i < ls.size(); i++) {
				TaskList l = ls.get(i);
				if (i == 0 && listid == null)
					listid = "" + l.getId();

				if (i != 0) {
					names += ",";
				}

				names += l.getDescription();

				if (("" + l.getId()).equals(listid)
						|| (l.getDescription().equals(tab) && !tab.equals(""))) {
					model.put("formTab", l.getDescription());
					model.put("list", l.getId());
				}
			}

			model.put("formNames", names);

			/* Load Items */
			DynamicQuery dqi = DynamicQueryFactoryUtil.forClass(TaskItem.class);
			dqi.add(PropertyFactoryUtil.forName("list").eq(model.get("list")));
			dqi.addOrder(PropertyFactoryUtil.forName(order).asc());

			List<TaskItem> is = TaskItemLocalServiceUtil.dynamicQuery(dqi);
			model.put("itemList", is);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ModelAndView("view", model);

	}
}
