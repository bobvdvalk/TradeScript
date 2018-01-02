/*
 * Copyright 2016 Mawoo Nederland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
use("Bitstamp");

var product = "XRPEUR";
var raw_data = Bitstamp.currentPrice(product);
var data = JSON.parse(raw_data);
info(raw_data)
info("Current portfolio:");
var xrp = 134.10108;
info(xrp +" XRP");
info("ask price: "+ data.ask);
var cal = data.ask * xrp;
info("Total value: "+ cal);
