import SwiftUI
import shared

@main
class iOSApp: App {
    
    let dependencies: Dependencies
    let test: Test
    
    required init() {
        dependencies = DependenciesFactory.shared.create()
        test = dependencies.provideTest()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
