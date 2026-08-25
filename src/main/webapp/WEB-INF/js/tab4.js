
function createTabDwr() {
    return {
        title: 'DWR Tab',
        itemId: 'dwrTab',
        layout: 'fit',
        loader: {
            url: 'tab/index',
            scripts: true,
            autoLoad: true
        }
    };
}
/*function createTabDwr() {
    return {
        title: 'DWR Tab',
        itemId: 'dwrTab',
		
        layout: 'fit',
        html: '<div>Loading...</div>',
        listeners: {
            activate: function (tab) {
                Demo.util.TabLoader.loadJspIntoTab(tab);
            }
        }
    };
}
Ext.define('Demo.util.TabLoader', {
    singleton: true,

    loadJspIntoTab: function (tab) {
        Ext.Ajax.request({
            url:'tab/index',   // e.g. /OakLand/tab/dwr
            method: 'GET',
			scripts:true,
            success: function (response) {
                tab.update(response.responseText);
            },
            failure: function () {
                tab.update('<div style="color:red;">Error loading tab content</div>');
            }
        });
    }
});*/