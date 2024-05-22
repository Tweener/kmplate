import SwiftUI
import shared

@main
class iOSApp: App {
    
    required init() {
        KoinIosDIKt.doInitKoin()
        LibrariesConfigurationHelper().doInitConfigurations()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
