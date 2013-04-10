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

import com.jesuslc.demos.browntasks.NoSuchTaskItemException;
import com.jesuslc.demos.browntasks.model.TaskItem;
import com.jesuslc.demos.browntasks.model.impl.TaskItemImpl;
import com.jesuslc.demos.browntasks.model.impl.TaskItemModelImpl;

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
 * The persistence implementation for the task item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jesus
 * @see TaskItemPersistence
 * @see TaskItemUtil
 * @generated
 */
public class TaskItemPersistenceImpl extends BasePersistenceImpl<TaskItem>
	implements TaskItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskItemUtil} to access the task item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemModelImpl.FINDER_CACHE_ENABLED, TaskItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemModelImpl.FINDER_CACHE_ENABLED, TaskItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the task item in the entity cache if it is enabled.
	 *
	 * @param taskItem the task item
	 */
	public void cacheResult(TaskItem taskItem) {
		EntityCacheUtil.putResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemImpl.class, taskItem.getPrimaryKey(), taskItem);

		taskItem.resetOriginalValues();
	}

	/**
	 * Caches the task items in the entity cache if it is enabled.
	 *
	 * @param taskItems the task items
	 */
	public void cacheResult(List<TaskItem> taskItems) {
		for (TaskItem taskItem : taskItems) {
			if (EntityCacheUtil.getResult(
						TaskItemModelImpl.ENTITY_CACHE_ENABLED,
						TaskItemImpl.class, taskItem.getPrimaryKey()) == null) {
				cacheResult(taskItem);
			}
			else {
				taskItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaskItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaskItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskItem taskItem) {
		EntityCacheUtil.removeResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemImpl.class, taskItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskItem> taskItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskItem taskItem : taskItems) {
			EntityCacheUtil.removeResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
				TaskItemImpl.class, taskItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task item with the primary key. Does not add the task item to the database.
	 *
	 * @param id the primary key for the new task item
	 * @return the new task item
	 */
	public TaskItem create(long id) {
		TaskItem taskItem = new TaskItemImpl();

		taskItem.setNew(true);
		taskItem.setPrimaryKey(id);

		return taskItem;
	}

	/**
	 * Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the task item
	 * @return the task item that was removed
	 * @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaskItem remove(long id)
		throws NoSuchTaskItemException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the task item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task item
	 * @return the task item that was removed
	 * @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem remove(Serializable primaryKey)
		throws NoSuchTaskItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskItem taskItem = (TaskItem)session.get(TaskItemImpl.class,
					primaryKey);

			if (taskItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskItem);
		}
		catch (NoSuchTaskItemException nsee) {
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
	protected TaskItem removeImpl(TaskItem taskItem) throws SystemException {
		taskItem = toUnwrappedModel(taskItem);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, taskItem);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(taskItem);

		return taskItem;
	}

	@Override
	public TaskItem updateImpl(
		com.jesuslc.demos.browntasks.model.TaskItem taskItem, boolean merge)
		throws SystemException {
		taskItem = toUnwrappedModel(taskItem);

		boolean isNew = taskItem.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, taskItem, merge);

			taskItem.setNew(false);
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

		EntityCacheUtil.putResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
			TaskItemImpl.class, taskItem.getPrimaryKey(), taskItem);

		return taskItem;
	}

	protected TaskItem toUnwrappedModel(TaskItem taskItem) {
		if (taskItem instanceof TaskItemImpl) {
			return taskItem;
		}

		TaskItemImpl taskItemImpl = new TaskItemImpl();

		taskItemImpl.setNew(taskItem.isNew());
		taskItemImpl.setPrimaryKey(taskItem.getPrimaryKey());

		taskItemImpl.setId(taskItem.getId());
		taskItemImpl.setList(taskItem.getList());
		taskItemImpl.setLabel(taskItem.getLabel());
		taskItemImpl.setWeight(taskItem.getWeight());
		taskItemImpl.setDescription(taskItem.getDescription());
		taskItemImpl.setStatus(taskItem.getStatus());

		return taskItemImpl;
	}

	/**
	 * Returns the task item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task item
	 * @return the task item
	 * @throws com.liferay.portal.NoSuchModelException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the task item with the primary key or throws a {@link com.jesuslc.demos.browntasks.NoSuchTaskItemException} if it could not be found.
	 *
	 * @param id the primary key of the task item
	 * @return the task item
	 * @throws com.jesuslc.demos.browntasks.NoSuchTaskItemException if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaskItem findByPrimaryKey(long id)
		throws NoSuchTaskItemException, SystemException {
		TaskItem taskItem = fetchByPrimaryKey(id);

		if (taskItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchTaskItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return taskItem;
	}

	/**
	 * Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task item
	 * @return the task item, or <code>null</code> if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the task item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the task item
	 * @return the task item, or <code>null</code> if a task item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TaskItem fetchByPrimaryKey(long id) throws SystemException {
		TaskItem taskItem = (TaskItem)EntityCacheUtil.getResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
				TaskItemImpl.class, id);

		if (taskItem == _nullTaskItem) {
			return null;
		}

		if (taskItem == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				taskItem = (TaskItem)session.get(TaskItemImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (taskItem != null) {
					cacheResult(taskItem);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TaskItemModelImpl.ENTITY_CACHE_ENABLED,
						TaskItemImpl.class, id, _nullTaskItem);
				}

				closeSession(session);
			}
		}

		return taskItem;
	}

	/**
	 * Returns all the task items.
	 *
	 * @return the task items
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaskItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the task items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of task items
	 * @param end the upper bound of the range of task items (not inclusive)
	 * @return the range of task items
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaskItem> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the task items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of task items
	 * @param end the upper bound of the range of task items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task items
	 * @throws SystemException if a system exception occurred
	 */
	public List<TaskItem> findAll(int start, int end,
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

		List<TaskItem> list = (List<TaskItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TASKITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKITEM;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TaskItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TaskItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the task items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TaskItem taskItem : findAll()) {
			remove(taskItem);
		}
	}

	/**
	 * Returns the number of task items.
	 *
	 * @return the number of task items
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKITEM);

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
	 * Initializes the task item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jesuslc.demos.browntasks.model.TaskItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaskItem>> listenersList = new ArrayList<ModelListener<TaskItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaskItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaskItemImpl.class.getName());
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
	private static final String _SQL_SELECT_TASKITEM = "SELECT taskItem FROM TaskItem taskItem";
	private static final String _SQL_COUNT_TASKITEM = "SELECT COUNT(taskItem) FROM TaskItem taskItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskItem exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaskItemPersistenceImpl.class);
	private static TaskItem _nullTaskItem = new TaskItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaskItem> toCacheModel() {
				return _nullTaskItemCacheModel;
			}
		};

	private static CacheModel<TaskItem> _nullTaskItemCacheModel = new CacheModel<TaskItem>() {
			public TaskItem toEntityModel() {
				return _nullTaskItem;
			}
		};
}