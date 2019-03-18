import io
import json

from fdk import response

def handler(ctx, data: io.BytesIO=None):
    body = json.loads(data.getvalue())
    customer_number = body.get("customerNumber")
    notification_permitted = customer_number % 2 == 1
    
    return response.Response(
        ctx, response_data = json.dumps(
            {"notificationPermitted": notification_permitted}),
        headers={"Content-Type": "application/json"}
    )
