import SwiftUI
import shared
import os

@main
class iOSApp: App {
    
    let dependencies: Dependencies
    
    required init() {
        dependencies = DependenciesFactory.shared.create()
        let test = dependencies.provideTest()
        
        Logger().debug("Test OUI: \(test.name)")
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
