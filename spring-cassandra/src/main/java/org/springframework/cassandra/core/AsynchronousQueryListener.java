/*
 * Copyright 2011-2014 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cassandra.core;

import com.datastax.driver.core.ResultSetFuture;

/**
 * Interface used to give an implementation access to a {@link ResultSetFuture} after the query has completed.
 * 
 * @author David Webb
 */
public interface AsynchronousQueryListener {

	/**
	 * Called upon Query Completion.
	 * 
	 * @param rsf The {@link ResultSetFuture}. Since this isn't called until the asynchronous query completes, it can be
	 *          immediately interrogated.
	 */
	public void onQueryComplete(ResultSetFuture rsf);
}
