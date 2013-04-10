package com.jesuslc.demos.browntasks.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.jesuslc.demos.browntasks.model.TaskItem;
import com.jesuslc.demos.browntasks.service.TaskItemLocalService;
import com.jesuslc.demos.browntasks.service.TaskItemLocalServiceUtil;
import com.jesuslc.demos.browntasks.util.ModelAndView;
import com.liferay.counter.service.CounterLocalServiceUtil;

public class AddItemController {
	TaskItemLocalService taskItemLocalService=TaskItemLocalServiceUtil.getService();

	public void handleActionRequest(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		int id=-1;
		if ( request.getParameter("id")!=null ) {
			id=Integer.parseInt( request.getParameter("id") );
			}
		try {
		response.setRenderParameter("action","view");
		if ( request.getParameter("order")!=null ) 
			response.setRenderParameter("order", request.getParameter("order") );

		if ( request.getParameter("list")!=null )
			response.setRenderParameter("list", request.getParameter("list") );

		if ( request.getParameter("delete")!=null ) {
			taskItemLocalService.deleteTaskItem( (long) id );

			return;
			}

		TaskItem l;
		if ( id==-1 )
			l=taskItemLocalService.createTaskItem( CounterLocalServiceUtil.increment(TaskItem.class.getName()) );
			else
			l=taskItemLocalService.getTaskItem( id );

		l.setList( Integer.parseInt( request.getParameter("list") )  );
		l.setLabel( request.getParameter("label") );
		l.setDescription( request.getParameter("description") );
		l.setWeight( Integer.parseInt( request.getParameter("weight") ) );
		l.setStatus( Integer.parseInt( request.getParameter("status") ) );

		if ( id==-1 )
			taskItemLocalService.addTaskItem( l );
			else
			taskItemLocalService.updateTaskItem( l );
		} catch (Exception ex) { ex.printStackTrace(); }
		}

	public ModelAndView handleRenderRequest(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		Map<String, Object> model = new HashMap<String, Object>();

		String itemid=request.getParameter("itemid");

		try{
			if ( itemid!=null ) {
				TaskItem l=taskItemLocalService.getTaskItem( Integer.parseInt( itemid ) );

				model.put( "item", l );
				}
	
			model.put( "list", request.getParameter("list") );
			if ( request.getParameter("order")!=null ) 
				model.put("order", request.getParameter("order") );
		} catch (Exception ex) { ex.printStackTrace(); }


		return new ModelAndView("additem", model);
		}
}
