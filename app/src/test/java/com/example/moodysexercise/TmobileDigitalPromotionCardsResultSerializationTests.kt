package com.example.moodysexercise

import com.example.moodysexercise.data.network.model.CardWrapper
import com.example.moodysexercise.data.network.model.Page
import com.example.moodysexercise.data.network.model.ProductPageResponse
import kotlinx.serialization.json.Json
import org.junit.Test

class TmobileDigitalPromotionCardsResultSerializationTests {

    @Test
    fun `list of each card serialization test`() {
        val inputPageData = """[
  {
    "card_type": "text",
    "card": {
      "value": "Hello, Welcome to App!",
      "attributes": {
        "text_color": "#262626",
        "font": {
          "size": 30
        }
      }
    }
  },
  {
    "card_type": "title_description",
    "card": {
      "title": {
        "value": "Check out our App every week for exciting offers.",
        "attributes": {
          "text_color": "#262626",
          "font": {
            "size": 24
          }
        }
      },
      "description": {
        "value": "Offers available every week!",
        "attributes": {
          "text_color": "#262626",
          "font": {
            "size": 18
          }
        }
      }
    }
  },
  {
    "card_type": "image_title_description",
    "card": {
      "image": {
        "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Featured@4.76x.png",
        "size": {
          "width": 1170,
          "height": 1498
        }
      },
      "title": {
        "value": "Movie ticket to Dark Phoenix!",
        "attributes": {
          "text_color": "#FFFFFF",
          "font": {
            "size": 18
          }
        }
      },
      "description": {
        "value": "Tap to see offer dates and rescriptions.",
        "attributes": {
          "text_color": "#FFFFFF",
          "font": {
            "size": 12
          }
        }
      }
    }
  }
]""".trimIndent()
        val cardListData: List<CardWrapper> = Json.decodeFromString(inputPageData)
        println(cardListData)
    }

    @Test
    fun `full card list serialization test`() {
        val inputPageData = """[
      {
        "card_type": "text",
        "card": {
          "value": "Hello, Welcome to App!",
          "attributes": {
            "text_color": "#262626",
            "font": {
              "size": 30
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "Check out our App every week for exciting offers.",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 24
              }
            }
          },
          "description": {
            "value": "Offers available every week!",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 18
              }
            }
          }
        }
      },
      {
        "card_type": "image_title_description",
        "card": {
          "image": {
            "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Featured@4.76x.png",
            "size": {
              "width": 1170,
              "height": 1498
            }
          },
          "title": {
            "value": "Movie ticket to Dark Phoenix!",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 18
              }
            }
          },
          "description": {
            "value": "Tap to see offer dates and rescriptions.",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 12
              }
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "This is a sample text title v1",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "This is a sample text description v1",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 12
              }
            }
          }
        }
      },
      {
        "card_type": "image_title_description",
        "card": {
          "image": {
            "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Tuesday2@4.76x.png",
            "size": {
              "width": 1170,
              "height": 1170
            }
          },
          "title": {
            "value": "25% off merch at t-mobile.com",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "Tap to see offer dates and rescriptions.",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 13
              }
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "This is a sample text title v2",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "This is a sample text description v2",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 14
              }
            }
          }
        }
      }
    ]
""".trimIndent()
        val cardListData: List<CardWrapper> = Json.decodeFromString(inputPageData)
        println(cardListData)
    }

    @Test
    fun `ProductPageResponse serialization test`() {
        val inputPageData = """{
    "cards": [
      {
        "card_type": "text",
        "card": {
          "value": "Hello, Welcome to App!",
          "attributes": {
            "text_color": "#262626",
            "font": {
              "size": 30
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "Check out our App every week for exciting offers.",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 24
              }
            }
          },
          "description": {
            "value": "Offers available every week!",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 18
              }
            }
          }
        }
      },
      {
        "card_type": "image_title_description",
        "card": {
          "image": {
            "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Featured@4.76x.png",
            "size": {
              "width": 1170,
              "height": 1498
            }
          },
          "title": {
            "value": "Movie ticket to Dark Phoenix!",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 18
              }
            }
          },
          "description": {
            "value": "Tap to see offer dates and rescriptions.",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 12
              }
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "This is a sample text title v1",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "This is a sample text description v1",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 12
              }
            }
          }
        }
      },
      {
        "card_type": "image_title_description",
        "card": {
          "image": {
            "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Tuesday2@4.76x.png",
            "size": {
              "width": 1170,
              "height": 1170
            }
          },
          "title": {
            "value": "25% off merch at t-mobile.com",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "Tap to see offer dates and rescriptions.",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 13
              }
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "This is a sample text title v2",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "This is a sample text description v2",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 14
              }
            }
          }
        }
      }
    ]
}
""".trimIndent()
        val pageData: Page = Json.decodeFromString(inputPageData)
        println(pageData)
    }

    @Test
    fun `Full serialization test`() {
        val inputPageData = """{
  "page": {
    "cards": [
      {
        "card_type": "text",
        "card": {
          "value": "Hello, Welcome to App!",
          "attributes": {
            "text_color": "#262626",
            "font": {
              "size": 30
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "Check out our App every week for exciting offers.",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 24
              }
            }
          },
          "description": {
            "value": "Offers available every week!",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 18
              }
            }
          }
        }
      },
      {
        "card_type": "image_title_description",
        "card": {
          "image": {
            "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Featured@4.76x.png",
            "size": {
              "width": 1170,
              "height": 1498
            }
          },
          "title": {
            "value": "Movie ticket to Dark Phoenix!",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 18
              }
            }
          },
          "description": {
            "value": "Tap to see offer dates and rescriptions.",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 12
              }
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "This is a sample text title v1",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "This is a sample text description v1",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 12
              }
            }
          }
        }
      },
      {
        "card_type": "image_title_description",
        "card": {
          "image": {
            "url": "https://qaevolution.blob.core.windows.net/assets/ios/3x/Tuesday2@4.76x.png",
            "size": {
              "width": 1170,
              "height": 1170
            }
          },
          "title": {
            "value": "25% off merch at t-mobile.com",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "Tap to see offer dates and rescriptions.",
            "attributes": {
              "text_color": "#FFFFFF",
              "font": {
                "size": 13
              }
            }
          }
        }
      },
      {
        "card_type": "title_description",
        "card": {
          "title": {
            "value": "This is a sample text title v2",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 20
              }
            }
          },
          "description": {
            "value": "This is a sample text description v2",
            "attributes": {
              "text_color": "#262626",
              "font": {
                "size": 14
              }
            }
          }
        }
      }
    ]
  }
}
""".trimIndent()
        val pageData: ProductPageResponse = Json.decodeFromString(inputPageData)
        println(pageData)
    }
}
