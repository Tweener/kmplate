import SwiftUI
import shared

@main
class iOSApp: App {
    
    required init() {
        KoinIosDIKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
