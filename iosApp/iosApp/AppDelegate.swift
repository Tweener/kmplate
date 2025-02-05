//
//  AppDelegate.swift
//  iosApp
//
//  Created by Vivien Mahé on 05/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
import FirebaseCore
import FirebaseMessaging
import GoogleSignIn
import OSLog

@MainActor
class AppDelegate : NSObject, UIApplicationDelegate {
    
    func application(_ app: UIApplication, open url: URL, options: [UIApplication.OpenURLOptionsKey : Any] = [:]) -> Bool {
        return GIDSignIn.sharedInstance.handle(url)
    }
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        LibrariesConfigurationHelper().doInitConfigurations()
        return true
    }
    
    func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
        Messaging.messaging().apnsToken = deviceToken
    }
    
    func application(_ application: UIApplication, continue userActivity: NSUserActivity, restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void) -> Bool {
        if userActivity.activityType == NSUserActivityTypeBrowsingWeb,
           let url = userActivity.webpageURL {
            handleIncomingURL(url)
            return true
        }
        
        print("No valid URL in user activity.")
        return false
    }
    
    func handleIncomingURL(_ url: URL) {
        print("handleIncomingURL", url)
        
        // First check if the URL is handled by Google Sign In
        if (GIDSignIn.sharedInstance.handle(url)) {
            print("Handled by GIDSignIn")
        }

        // Then check if the URL is handled by Passage (Firebase Authentication)
        else if (PassageHelper().handle(url: url.absoluteString)) {
            print("Handled by Passage")
        }
    }
}
