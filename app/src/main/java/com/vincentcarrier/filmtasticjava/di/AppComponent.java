/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.vincentcarrier.filmtasticjava.di;

import android.arch.lifecycle.ViewModel;

import com.vincentcarrier.filmtasticjava.App;
import com.vincentcarrier.repository.MoviesRepoModule;
import com.vincentcarrier.repository.TheMovieDbServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
		AppModule.class,
		MoviesRepoModule.class,
		TheMovieDbServiceModule.class
})
public interface AppComponent {
//	@Component.Builder
//	interface Builder {
//		@BindsInstance
//		Builder application(Application application);
//
//		AppComponent build();
//	}

	void inject(App app);
	void inject(ViewModel viewModel);
}
