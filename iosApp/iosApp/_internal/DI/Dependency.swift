//
//  Dependency.swift
//  iosApp
//
//  Created by Vivien Mahé on 05/06/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Swinject

class Dependency {
    
    static var shared: Dependency = { Dependency() }()

    let container = Container()
    var assembler: Assembler!
    var resolver: Resolver { assembler.resolver }
    
    func initialize() {
        assembler = Assembler(
            [
                // Add here all global dependencies
                MainAssembly()
            ],
            container: container
        )
    }
}
