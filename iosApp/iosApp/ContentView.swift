import SwiftUI
import shared

struct ContentView: View {
    private var greeting = Dependency.shared.resolver.resolve(Greeting.self)!

	var body: some View {
        Text(greeting.greet())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
