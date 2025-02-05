import SwiftUI
import shared

@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    init() {
        KoinIosDIKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView().onOpenURL(perform: { url in
                appDelegate.handleIncomingURL(url)
            })
        }
    }
}
