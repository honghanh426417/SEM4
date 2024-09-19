import 'package:flutter/material.dart';

void main(){
  runApp(
    const MaterialApp(
      title: 'Flutter Tutorial',
      home: TutorialHome(),
    ),
  );
}
class TutorialHome extends StatelessWidget{
  const TutorialHome({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: const IconButton(
            icon: Icon(Icons.menu),
            tooltip: 'Navigation menu',
            onPressed: null,
        ),
        title: const Text('Example title'),
        actions: const[
          IconButton(
              onPressed: null,
              icon: Icon(Icons.search),
            tooltip: 'Search',
          ),
        ],
      ),
      body: const Center(
        child: Text('Helloo, world!'),
      ),
      floatingActionButton: const FloatingActionButton(
        tooltip: 'Add',
        onPressed: null,
        child: Icon(Icons.add),
      ),
    );
    // TODO: implement build
    throw UnimplementedError();
  }
}