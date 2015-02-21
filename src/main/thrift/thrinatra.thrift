namespace scala com.foursquare.thrinatra

include "types.thrift"

struct Item {
  1: types.ObjectId id (wire_name="_id")
  2: string text
} (
  primary_key="id"
  mongo_collection="items"
  mongo_identifier="thrinatra"
)
