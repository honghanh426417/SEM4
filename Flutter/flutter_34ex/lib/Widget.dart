import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart' show debugPaintSizeEnabled;
import 'package:flutter_34ex/main.dart';

void main(){
  debugPaintSizeEnabled = false;
  runApp(const MyApp());
}

class MyApp extends StatelessWidget{
  const MyApp({super.key});

  static const showGrid = true;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter layout demo',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter layout demo'),
        ),
        body: Center(child: showGrid ? _buildGrid() : _buildList()),
      ),
    );
  }
}

Widget _buildGrid() => GridView.extent(
  maxCrossAxisExtent: 150,
  padding: const EdgeInsets.all(4),
  mainAxisSpacing: 4,
  crossAxisSpacing: 4,
  children: _buildGridTitleList(30)
  );

  List<Container> _buildGridTitleList(int count) => List.generate(
    count, (i) => Container(child: Image.asset('image/pic$i.jpg'))
    );

    Widget _buildList(){
      return ListView(
        children: [
          _title('CineArts at the Empire', '85 W Portal Ave', Icons.theaters),
          _title('The Castro Theater', '429 Castro St', Icons.theaters),
          _title('Alamo Drafthouse Cinema', '2550 Mission St', Icons.theaters),
          _title('Roxie Theater', '3117 16th St', Icons.theaters),
          _title('United Artists Stone Twin', '501 Buckingham Way', Icons.theaters),
          _title('AMC Metreon 16', '135 14th ST #300', Icons.theaters),
          _title('K\'s Kitchen', '757 Monterey Blvd', Icons.restaurant),
          _title('Emmy\'s Restaurant', '1923 Ocean Ave', Icons.restaurant),
          _title('Chaiya Thai Restaurant', '272 Claremont Blvd', Icons.restaurant),
          _title('La Ciccia', '291 30th St', Icons.restaurant),

        ],
      );
    }

    ListTile _title(String title, String subtitle, IconData icon){
      return ListTile(
        title: Text(title,
        style: const TextStyle(
          fontWeight: FontWeight.w500,
          fontSize: 20,
           )),
           subtitle: Text(subtitle),
           leading: Icon(
            icon,
            color: Colors.blue[500],
           ),
      );
    }
    