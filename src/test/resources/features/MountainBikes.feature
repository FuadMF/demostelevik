Feature: MountainBikes


  Background:
    When Click login button
    And Move to categories button
    And Click Bikes button
    And Click Mountain Bikes button



#  Scenario Outline: Check Model filter
#    Given User is in "Eshop web" page
#    And Click "<Model>" button
#    Then User should see items "<Model>" on the page
#    Examples:
#      | Model                                                              |
#      | Mountain-100                                                       |
#      | Mountain-200                                                       |
#      | Mountain-300                                                       |
#      | Mountain-400-W                                                     |
#      | Mountain-500                                                       |
#      | Mountain-100&Mountain-200                                          |
#      | Mountain-100&Mountain-200&Mountain-300                             |
#      | Mountain-100&Mountain-200&Mountain-300&Mountain-400-W              |
#      | Mountain-100&Mountain-200&Mountain-300&Mountain-400-W&Mountain-500 |
#
#
#  Scenario Outline: Check Size filter
#    Given User is in "Eshop web" page
#    And Click "<Size>" button
#    Then User should see items "<Size>" on the page
#    Examples:
#      | Size                 |
#      | 38                   |
#      | 40                   |
#      | 42                   |
#      | 44                   |
#      | 46                   |
#      | 48                   |
#      | 52                   |
#      | 38&40                |
#      | 38&40&42             |
#      | 38&40&42&44          |
#      | 38&40&42&44&46       |
#      | 38&40&42&44&46&48    |
#      | 38&40&42&44&46&48&52 |
#
#  Scenario Outline: Check Color filter
#    Given User is in "Eshop web" page
#    And Click "<Color>" button
#    Then User should see items "<Color>" on the page
#    Examples:
#      | Color        |
#      | Black        |
#      | Silver       |
#      | Black&Silver |
#
#  Scenario Outline: Check all Filters
#    Given User is in "Eshop web" page
#    And Click "<Categories>" button
#    Then User should see items "<Categories>" on the page
#    Examples:
#      | Categories               |
#      | Mountain-100&38&Black    |
#      | Mountain-100&38&Silver   |
#      | Mountain-200&38&Black    |
#      | Mountain-200&38&Silver   |
#      | Mountain-300&38&Black    |
#      | Mountain-400-W&38&Silver |
#      | Mountain-500&40&Black    |
#      | Mountain-500&40&Silver   |

# Scenario Outline: Check rating filter
#   Given User is in "Eshop web" page
#   When Clicks "<Rating>" button
#   Then Users should see items "<ratingText>" on the page
#   Examples:
#     | Rating | ratingText |
#     | 5      | 5/5        |
#     | 4      | 4/5        |
#     | 2      | 2/5        |
#
#  Scenario Outline: Check rating empty filter
#   Given User is in "Eshop web" page
#   When Clicks "<Rating>" button
#   Then User should see nothing  on the page
#   Examples:
#     | Rating |
#     | 3      |
#     | 1      |

  Scenario Outline: Check price interval
    Given User is in "Eshop web" page
    When User choose price interval "<from>" "<to>"
    Then Items shoul be list according to "<from>" "<to>"
    Examples:
      | from | to    |
      | 500  | 2,000 |


  Scenario Outline: Check price interval
    Given User is in "Eshop web" page
    When User choose weight interval "<from>" "<to>"
    Then Items shoul be list according to "<from>" "<to>"
    Examples:
      | from | to    |
      | 500  | 2,000 |




#  Scenario: Check Low to High filter
#    Given User is in "Eshop web" page
#    When Click Low to High filter
#    Then Items should be ordered as Low to High price
#
#  Scenario: Check High to Low filter
#    Given User is in "Eshop web" page
#    When Click High to Low filter
#    Then Items should be ordered as High to Low price
#
#  Scenario: Check A to Z filter
#    Given User is in "Eshop web" page
#    When Click A to Z filter
#    Then Items should be ordered as A to Z
#
#  Scenario: Check A to Z filter
#    Given User is in "Eshop web" page
#    When Click Z to A filter
#    Then Items should be ordered as Z to A


