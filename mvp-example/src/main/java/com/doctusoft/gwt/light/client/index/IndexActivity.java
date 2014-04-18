package com.doctusoft.gwt.light.client.index;

import lombok.MethodRef;
import lombok.ObservableAttribute;

import com.doctusoft.gwt.light.ViewOf;
import com.doctusoft.gwt.light.shared.ClientFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class IndexActivity extends AbstractActivity {
	
	private ClientFactory clientFactory;
	
	@ObservableAttribute
	private String name;
	
	@ObservableAttribute
	private String greetingLabel;

	public IndexActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ViewOf<IndexActivity> view = clientFactory.getIndexView();
		view.setPresenter(this);
		panel.setWidget(view);
	}

	@MethodRef
	public void greet() {
		// you have to use the setter. Field assignment won't raise a change event
		setGreetingLabel("Hello: " + name);
	}
}
