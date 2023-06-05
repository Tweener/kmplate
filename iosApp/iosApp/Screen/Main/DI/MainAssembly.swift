//
//  MainAssembly.swift
//  iosApp
//
//  Created by Vivien Mahé on 05/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Swinject
import shared

class MainAssembly : Assembly {
    
    func assemble(container: Container) {
        container.register(PlatformRepository.self) { _ in PlatformRepositoryImpl() }
        
        container.register(Greeting.self) { r in Greeting(platformRepository: r.resolve(PlatformRepository.self)!) }
    }
}
