package org.marianoguerra.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;

public class DynamicScopeContextFactory extends ContextFactory {
	// default is to use non-dynamic scopes, which is to maintain compatibility with how clj-rhino worked
	// before this addition
	static boolean useDynamicScope = false;

	public static boolean toggleDynamicScopeCreation(boolean enable) {
		useDynamicScope = enable;
		return useDynamicScope;
	}

	@Override
	protected boolean hasFeature(Context cx, int featureIndex) {
		if (featureIndex == Context.FEATURE_DYNAMIC_SCOPE)
			return useDynamicScope;
		else
			return super.hasFeature(cx, featureIndex);
	}

	static {
		ContextFactory.initGlobal(new DynamicScopeContextFactory());
	}
}
