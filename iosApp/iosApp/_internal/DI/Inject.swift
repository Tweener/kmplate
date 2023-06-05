//
//  Inject.swift
//  iosApp
//
//  Created by Vivien Mahé on 05/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation

@propertyWrapper
struct Inject<I> {
    
    let wrappedValue: I
    
    init() {
        self.wrappedValue = Dependency.shared.resolver.resolve(I.self)!
    }
}
