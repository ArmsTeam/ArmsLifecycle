package org.arms.lifecycle.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ArmsTeam on 2017/10/2.
 * Dagger FragmentScope
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
