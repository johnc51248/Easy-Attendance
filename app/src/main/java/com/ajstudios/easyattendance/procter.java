import 'dart:convert';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

Future<http.Response> fetchBTCPrice() async {
  final response = await http.get(Uri.https('blockhain.info', 'ticker'));
  return response;
}

Widget buildBTCPrice() {
  return FutureBuilder<http.Response>(
    future: fetchBTCPrice(),
    builder: (context, snapshot) {
      if (snapshot.hasData) {
        int? statusCode = snapshot.data?.statusCode;
        if (statusCode == 200) {
          return Text("${BTCPrice.fromJson(jsonDecode(snapshot.data.body)).eur}");
        }
        return Text('$statusCode');

      } else if (snapshot.hasError) {
        return Text('${snapshot.error}');
      }
      return CircularProgressIndicator();
    },
  );
}

class BTCPrice {
  final double eur;
  BTCPrice({required this.eur});

  factory BTCPrice.fromJson(Map<String, dynamic> json) {
    print(json);
    return BTCPrice(
      eur: json['eur']['15m']
    );
  }
}
