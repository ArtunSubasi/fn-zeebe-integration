import io
import json

from fdk import response

def handler(ctx, data: io.BytesIO=None):
    try:
        notification_permitted = is_notification_permitted(data.getvalue())
    except (Exception) as ex:
        notification_permitted = False
        
    return response.Response(
        ctx, response_data = json.dumps(
            {"notificationPermitted": notification_permitted}),
        headers={"Content-Type": "application/json"}
    )

def is_notification_permitted(request_body):
    customer = json.loads(request_body)
    customer_number = customer.get("customerNumber")
    return customer_number % 2 == 1
