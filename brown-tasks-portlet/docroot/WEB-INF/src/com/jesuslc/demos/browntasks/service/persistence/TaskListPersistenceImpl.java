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

package com.jesuslc.demos.browntasks.service.persistence;

import com.jesuslc.demos.browntasks.NoSuchTaskListException;
import com.jesuslc.demos.browntasks.model.TaskList;
import com.jesuslc.demos.browntasks.model.impl.TaskListImpl;
import com.jesuslc.demos.browntasks.model.impl.TaskListModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the task list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jesus
 * @see TaskListPersistence
 * @see TaskListUtil
 * @generated
 */
public class TaskListPersistenceImpl extends BasePersistenceImpl<TaskList>
	implements TaskListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskListUtil} to access the task list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListModelImpl.FINDER_CACHE_ENABLED, TaskListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListModelImpl.FINDER_CACHE_ENABLED, TaskListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the task list in the entity cache if it is enabled.
	 *
	 * @param taskList the task list
	 */
	public void cacheResult(TaskList taskList) {
		EntityCacheUtil.putResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListImpl.class, taskList.getPrimaryKey(), taskList);

		taskList.resetOriginalValues();
	}

	/**
	 * Caches the task lists in the entity cache if it is enabled.
	 *
	 * @param taskLists the task lists
	 */
	public void cacheResult(List<TaskList> taskLists) {
		for (TaskList taskList : taskLists) {
			if (EntityCacheUtil.getResult(
						TaskListModelImpl.ENTITY_CACHE_ENABLED,
						TaskListImpl.class, taskList.getPrimaryKey()) == null) {
				cacheResult(taskList);
			}
			else {
				taskList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaskListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaskListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskList taskList) {
		EntityCacheUtil.removeResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListImpl.class, taskList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskList> taskLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskList taskList : taskLists) {
			EntityCacheUtil.removeResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
				TaskListImpl.class, taskList.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task list with the primary key. Does not add the task list to the database.
	 *
	 * @param id the primary key for the new task list
	 * @return the new task list
	 */
	public TaskList create(long id) {
		TaskList taskList = new TaskListImpl();

		taskList.setNew(true);
		taskList.setPrimaryKey(id);

		return taskList;
	}

	/**
	 * Removes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the task list
	 * @return the task list that was removed
	 * @throws com.jesuslc.demos.browntasks.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaskList remove(long id)
		throws NoSuchTaskListException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the task list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task list
	 * @return the task list that was removed
	 * @throws com.jesuslc.demos.browntasks.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList remove(Serializable primaryKey)
		throws NoSuchTaskListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskList taskList = (TaskList)session.get(TaskListImpl.class,
					primaryKey);

			if (taskList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskList);
		}
		catch (NoSuchTaskListException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TaskList removeImpl(TaskList taskList) throws SystemException {
		taskList = toUnwrappedModel(taskList);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, taskList);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(taskList);

		return taskList;
	}

	@Override
	public TaskList updateImpl(
		com.jesuslc.demos.browntasks.model.TaskList taskList, boolean merge)
		throws SystemException {
		taskList = toUnwrappedModel(taskList);

		boolean isNew = taskList.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taskList, merge);

			taskList.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
			TaskListImpl.class, taskList.getPrimaryKey(), taskList);

		return taskList;
	}

	protected TaskList toUnwrappedModel(TaskList taskList) {
		if (taskList instanceof TaskListImpl) {
			return taskList;
		}

		TaskListImpl taskListImpl = new TaskListImpl();

		taskListImpl.setNew(taskList.isNew());
		taskListImpl.setPrimaryKey(taskList.getPrimaryKey());

		taskListImpl.setId(taskList.getId());
		taskListImpl.setPortlet(taskList.getPortlet());
		taskListImpl.setDescription(taskList.getDescription());
		taskListImpl.setWeight(taskList.getWeight());

		return taskListImpl;
	}

	/**
	 * Returns the task list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task list
	 * @return the task list
	 * @throws com.liferay.portal.NoSuchModelException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the task list with the primary key or throws a {@link com.jesuslc.demos.browntasks.NoSuchTaskListException} if it could not be found.
	 *
	 * @param id the primary key of the task list
	 * @return the task list
	 * @throws com.jesuslc.demos.browntasks.NoSuchTaskListException if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaskList findByPrimaryKey(long id)
		throws NoSuchTaskListException, SystemException {
		TaskList taskList = fetchByPrimaryKey(id);

		if (taskList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTaskListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return taskList;
	}

	/**
	 * Returns the task list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task list
	 * @return the task list, or <code>null</code> if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the task list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the task list
	 * @return the task list, or <code>null</code> if a task list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaskList fetchByPrimaryKey(long id) throws SystemException {
		TaskList taskList = (TaskList)EntityCacheUtil.getResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
				TaskListImpl.class, id);

		if (taskList == _nullTaskList) {
			return null;
		}

		if (taskList == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				taskList = (TaskList)session.get(TaskListImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (taskList != null) {
					cacheResult(taskList);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TaskListModelImpl.ENTITY_CACHE_ENABLED,
						TaskListImpl.class, id, _nullTaskList);
				}

				closeSession(session);
			}
		}

		return taskList;
	}

	/**
	 * Returns all the task lists.
	 *
	 * @return the task lists
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaskList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of task lists
	 * @param end the upper bound of the range of task lists (not inclusive)
	 * @return the range of task lists
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaskList> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of task lists
	 * @param end the upper bound of the range of task lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task lists
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaskList> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TaskList> list = (List<TaskList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TASKLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKLIST;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TaskList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaskList>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the task lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TaskList taskList : findAll()) {
			remove(taskList);
		}
	}

	/**
	 * Returns the number of task lists.
	 *
	 * @return the number of task lists
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKLIST);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the task list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jesuslc.demos.browntasks.model.TaskList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaskList>> listenersList = new ArrayList<ModelListener<TaskList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaskList>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TaskListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = TaskItemPersistence.class)
	protected TaskItemPersistence taskItemPersistence;
	@BeanReference(type = TaskListPersistence.class)
	protected TaskListPersistence taskListPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_TASKLIST = "SELECT taskList FROM TaskList taskList";
	private static final String _SQL_COUNT_TASKLIST = "SELECT COUNT(taskList) FROM TaskList taskList";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskList exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaskListPersistenceImpl.class);
	private static TaskList _nullTaskList = new TaskListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaskList> toCacheModel() {
				return _nullTaskListCacheModel;
			}
		};

	private static CacheModel<TaskList> _nullTaskListCacheModel = new CacheModel<TaskList>() {
			public TaskList toEntityModel() {
				return _nullTaskList;
			}
		};
}