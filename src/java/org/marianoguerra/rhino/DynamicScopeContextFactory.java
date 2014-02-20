package org.marianoguerra.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;

public class DynamicScopeContextFactory extends ContextFactory {
	static boolean useDynamicScope;

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
