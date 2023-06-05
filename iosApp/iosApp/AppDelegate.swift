//
//  AppDelegate.swift
//  iosApp
//
//  Created by Vivien Mahé on 05/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        // Initialize the dependency injection
        Dependency.shared.initialize()
        
        return true
    }
}

