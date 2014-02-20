package org.marianoguerra.rhino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;

public class DynamicScopeContextFactory extends ContextFactory {
	public static boolean useDynamicScope;

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
